/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package sample.lrdev05.database.service.impl;

import java.util.Collections;
import java.util.List;


import sample.lrdev05.database.service.base.BooksLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the books local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.books.database.service.BooksLocalService} interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.books.database.service.BooksLocalServiceUtil} to access the books
 * local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author mshanmugam
 * @see com.books.database.service.base.BooksLocalServiceBaseImpl
 * @see com.books.database.service.BooksLocalServiceUtil
 */
public class BooksLocalServiceImpl extends BooksLocalServiceBaseImpl {

	public sample.lrdev05.database.model.Books addBooks(Books booksParam,long userId,
	        ServiceContext serviceContext){
		sample.lrdev05.database.model.Books booksVar;

		try {
			booksVar = booksPersistence.create(counterLocalService
					.increment(Books.class.toString()));
		} catch (SystemException e) {
			e.printStackTrace();
			return booksVar = null;
		}

		
		booksVar.setTitle(booksParam.getTitle());
		booksVar.setAuthor(booksParam.getAuthor());
		booksVar.setIsbn(booksParam.getIsbn());
		booksVar.setSummary(booksParam.getSummary());
		booksVar.setCompanyId(booksParam.getCompanyId());
		booksVar.setGroupId(booksParam.getGroupId());
		booksVar.setTitle(booksParam.getTitle());
		booksVar.setStatus(WorkflowConstants.STATUS_DRAFT);
		
		try {
			resourceLocalService.addResources(booksParam.getCompanyId(),
					booksParam.getGroupId(), userId,
					Books.class.getName(), booksParam.getPrimaryKey(), false,
					true, true);
			assetEntryLocalService.updateEntry(
					userId, booksVar.getGroupId(), Books.class.getName(),
					booksVar.getBookId(), serviceContext.getAssetCategoryIds(),
			        serviceContext.getAssetTagNames());
			//Workflow
			WorkflowHandlerRegistryUtil.startWorkflowInstance(
					booksVar.getCompanyId(), booksVar.getGroupId(), userId,
					Books.class.getName(), booksVar.getPrimaryKey(), booksVar,
		            serviceContext);

		        sendMessage(booksVar, serviceContext);

		} catch (PortalException e) {
			e.printStackTrace();
			return booksVar = null;
		} catch (SystemException e) {
			e.printStackTrace();
			return booksVar = null;
		}

		try {
			return booksPersistence.update(booksVar, false);
		} catch (SystemException e) {
			e.printStackTrace();
			return booksVar = null;
		}
	}
	
	public Books updateBooks(Books booksParam, long userId) throws PortalException {
		Books booksVar;
		try {
			booksVar = booksPersistence.findByPrimaryKey(booksParam.getBookId());
			booksVar.setTitle(booksParam.getTitle());
			booksVar.setAuthor(booksParam.getAuthor());
			booksVar.setIsbn(booksParam.getIsbn());
			booksVar.setSummary(booksParam.getSummary());
			booksVar.setCompanyId(booksParam.getCompanyId());
			booksVar.setGroupId(booksParam.getGroupId());
			booksVar.setTitle(booksParam.getTitle());
			
			User user = userLocalService.getUser(userId);
			return booksPersistence.update(booksVar, true);
		} catch (NoSuchooksException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return booksVar = null;
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return booksVar = null;
		}
		
	}
	
	public Books updateStatus(
            long userId, long resourcePrimKey, int status,
            ServiceContext serviceContext)
        throws PortalException, SystemException {

        User user = userLocalService.getUser(userId);
        Books book = getBooks(resourcePrimKey);

        book.setStatus(status);
        book.setStatusByUserId(userId);
        book.setStatusByUserName(user.getFullName());
        book.setStatusDate(serviceContext.getModifiedDate());

        booksPersistence.update(book, false);

        if (status == WorkflowConstants.STATUS_APPROVED) {
            assetEntryLocalService.updateVisible(
                Books.class.getName(), resourcePrimKey, true);
        }
        else {
            assetEntryLocalService.updateVisible(
            	Books.class.getName(), resourcePrimKey, false);
        }

        // Indexer
        Indexer indexer = IndexerRegistryUtil.getIndexer(Books.class);
        indexer.reindex(book);
        return book;
    }


	public Books getBooksInstance() {
		try {
			return booksPersistence.create(counterLocalService
					.increment(Books.class.getName()));
		} catch (SystemException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Books> getAllBooks(long companyId) {
		try {
			return booksPersistence.findByCompanyId(companyId);
		} catch (SystemException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public List<Books> getAllBooks() {
		try {
			return booksPersistence.findAll();
		} catch (SystemException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public List<Books> getAllBooks(long groupId, String title) {
		try {
			return booksPersistence.findByGroup_Title(groupId, title);
		} catch (SystemException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public List<Books> getBooksByUserId(long userId) {
		try {
			return booksPersistence.findByUserId(userId);
		} catch (SystemException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deleteBooks(long booksId, long companyId) {

		Books books;
		try {
			books = booksPersistence.findByPrimaryKey(booksId);
		} catch (SystemException e) {
			e.printStackTrace();
			return;
		} catch (NoSuchooksException e) {
			e.printStackTrace();
			return;
		}
		deleteBooks(books, companyId);
	}

	public void deleteBooks(Books book, long companyId) {

		try {
			resourceLocalService.deleteResource(companyId,
					Books.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
					book.getPrimaryKey());
			assetEntryLocalService.deleteEntry(
					Books.class.getName(), book.getBookId());


		} catch (PortalException e) {
			e.printStackTrace();
			return;
		} catch (SystemException e) {
			e.printStackTrace();
			return;
		}
		try {
			booksPersistence.remove(book);
		} catch (SystemException e) {
			e.printStackTrace();
			return;
		}
	}

	//Workflow code
	private void sendMessage(
        Books book, ServiceContext serviceContext) {
        Message message = new Message();
        message.put("userId", serviceContext.getUserId());
        message.put("title", book.getTitle());
        MessageBusUtil.sendMessage("book/title", message);
	}

}