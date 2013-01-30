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

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.mail.internet.InternetAddress;

import sample.lrdev05.database.NoSuchBooksException;
import sample.lrdev05.database.model.Books;
import sample.lrdev05.database.service.base.BooksLocalServiceBaseImpl;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.audit.hook.listeners.util.Attribute;
import com.liferay.portal.audit.hook.listeners.util.AttributesBuilder;
import com.liferay.portal.kernel.audit.AuditException;
import com.liferay.portal.kernel.audit.AuditMessage;
import com.liferay.portal.kernel.audit.AuditRequestThreadLocal;
import com.liferay.portal.kernel.audit.AuditRouterUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

/**
 * The implementation of the books local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link sample.lrdev05.database.service.BooksLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author mshanmugam
 * @see sample.lrdev05.database.service.base.BooksLocalServiceBaseImpl
 * @see sample.lrdev05.database.service.BooksLocalServiceUtil
 */
public class BooksLocalServiceImpl extends BooksLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * sample.lrdev05.database.service.BooksLocalServiceUtil} to access the
	 * books local service.
	 */
	public Books addBooks(Books booksParam, long userId,
			ServiceContext serviceContext) {
		userId = 10195;
		try {
			
			Date now = new Date();
			User user = userLocalService.getUser(userId);
			Books booksVar;
			//Check for Primary key and create
			if(booksParam.getPrimaryKey() >  0){
				booksVar = booksPersistence.create(counterLocalService
						.increment(Books.class.toString()));
				booksVar.setStatus(WorkflowConstants.STATUS_DRAFT);
				booksVar.setCreateDate(serviceContext.getModifiedDate(now));
			}else{
				booksVar = booksParam;
				booksVar.setStatus(WorkflowConstants.STATUS_DRAFT_FROM_APPROVED);//Making it to go thro approval.
				booksVar.setModifiedDate(serviceContext.getModifiedDate(now));
			}
			
			//Domain model
			booksVar.setTitle(booksParam.getTitle());
			booksVar.setAuthor(booksParam.getAuthor());
			booksVar.setIsbn(booksParam.getIsbn());
			booksVar.setSummary(booksParam.getSummary());
			//Liferay specific values
			booksVar.setCompanyId(booksParam.getCompanyId());
			booksVar.setGroupId(booksParam.getGroupId());
			booksVar.setUserId(userId);
			//workflow crap
			booksVar.setResourcePrimKey(booksVar.getBookId());
			booksVar.setStatusByUserId(user.getUserId());
			booksVar.setStatusByUserName(user.getFullName());
			booksVar.setStatusDate(serviceContext.getModifiedDate(now));
			
			Books added = booksPersistence.update(booksVar, false);
			
			resourceLocalService.addResources(added.getCompanyId(),
					added.getGroupId(), userId, Books.class.getName(),
					added.getPrimaryKey(), false, true, true);
			
			assetEntryLocalService.updateEntry(userId, added.getGroupId(),
					Books.class.getName(), added.getPrimaryKey(),
					serviceContext.getAssetCategoryIds(),
					serviceContext.getAssetTagNames());
			
			// Workflow
			WorkflowHandlerRegistryUtil.startWorkflowInstance(
					added.getCompanyId(), added.getGroupId(), userId,
					Books.class.getName(), added.getPrimaryKey(), added,
					serviceContext);
			//TODO: enable mail server
			//TODO: Send email for everybody List<User> user_list = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			//TODO:  InternetAddress from = new InternetAddress("admin@liferayhost.com", "Liferay admin");
			//MailServiceUtil.sendEmail(mailMessage);
			// sendMessage(booksVar, serviceContext);

		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return booksParam;

	}

	
	public Books updateStatus(long userId, long resourcePrimKey, int status,
			ServiceContext serviceContext) throws PortalException,
			SystemException {
		userId = 10195;
		Date now = new Date();
		User user = userLocalService.getUser(userId);

		Books book = getLatestBook(resourcePrimKey,
				WorkflowConstants.STATUS_ANY);

		book.setModifiedDate(serviceContext.getModifiedDate(now));
		book.setStatus(status);
		System.out.println(" User Id "+user.getUserId()+ " FN " +user.getFullName());
		book.setStatusByUserId(user.getUserId());
		book.setStatusByUserName(user.getFullName());
		book.setStatusDate(serviceContext.getModifiedDate(now));
		booksPersistence.update(book, false);

		if (status == WorkflowConstants.STATUS_APPROVED) {
			assetEntryLocalService.updateVisible(Books.class.getName(),
					resourcePrimKey, true);
		} else {
			assetEntryLocalService.updateVisible(Books.class.getName(),
					resourcePrimKey, false);
		}
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

		Books books = null;
		try {
			try {
				books = booksPersistence.findByPrimaryKey(booksId);
			} catch (NoSuchBooksException e) {
				e.printStackTrace();
			}
		} catch (SystemException e) {
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
			assetEntryLocalService.deleteEntry(Books.class.getName(),
					book.getBookId());

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

	public Books getBooks(long resourcePrimKey) throws NoSuchBooksException,
			SystemException {
		Books book = booksPersistence.findByPrimaryKey(resourcePrimKey);
		return book;
	}


	public Books getLatestBook(long resourcePrimKey, int status)
			throws PortalException, SystemException {

		if(status == WorkflowConstants.STATUS_DRAFT){
			return booksPersistence.create(resourcePrimKey);
		}
		return booksPersistence.findByPrimaryKey(resourcePrimKey);

	}

	//Dummy 
	public Books updateBooks(Books booksParam, long userId)
			throws PortalException {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Workflow code
	private void sendMessage(

	Books book, ServiceContext serviceContext) {
		Message message = new Message();
		message.put("userId", serviceContext.getUserId());
		message.put("title", book.getTitle());
		MessageBusUtil.sendMessage("book/title", message);
	}

	
	//Audit code
	public void updateMyBean(Books oldBean, Books newBean) {

		Books oldBook = null;
		try {
			oldBook = getBooks(newBean.getBookId());
		} catch (NoSuchBooksException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List attributes = getModifiedAttributes(newBean, oldBook);
		Attribute att1 = new Attribute(Books.class.getName(),newBean.getTitle(),oldBook.getTitle());
		Attribute att2 = new Attribute(Books.class.getName(),newBean.getAuthor(),oldBook.getAuthor());
		Attribute att3 = new Attribute(Books.class.getName(),newBean.getIsbn(),oldBook.getIsbn());
		Attribute att4 = new Attribute(Books.class.getName(),newBean.getSummary(),oldBook.getSummary());
		attributes.add(att1);
		attributes.add(att2);
		attributes.add(att3);
		attributes.add(att4);
		// create the audit message
		AuditMessage auditMessage = buildAuditMessage(
				"Book Updated", Books.class.getName(), newBean.getBookId(),
				attributes);
		// add the audit message
		try {
			AuditRouterUtil.route(auditMessage);
		} catch (AuditException e) {
			e.printStackTrace();
		}
	}

	protected List<Attribute> getModifiedAttributes(Books newBook, Books oldBook) {
		AttributesBuilder attributesBuilder = new AttributesBuilder(newBook,
				oldBook);
		attributesBuilder.add("title");
		attributesBuilder.add("author");
		attributesBuilder.add("isbn");
		attributesBuilder.add("summary");
		return attributesBuilder.getAttributes();
	}
	
	public  AuditMessage buildAuditMessage( String eventType, String className, long classPK, 
			   List<com.liferay.portal.audit.hook.listeners.util.Attribute> attributes) {
			 long companyId = CompanyThreadLocal.getCompanyId();
			 long userId = 0;
			 if (PrincipalThreadLocal.getName() != null) { 
			   userId = GetterUtil.getLong(PrincipalThreadLocal.getName()); 
			 }
			 AuditRequestThreadLocal auditRequestThreadLocal = AuditRequestThreadLocal.getAuditThreadLocal();
			 long realUserId = auditRequestThreadLocal.getRealUserId(); 
			 String userName = PortalUtil.getUserName( userId, StringPool.BLANK);
			 String realUserName = PortalUtil.getUserName( realUserId, StringPool.BLANK);
			 JSONObject additionalInfo = JSONFactoryUtil.createJSONObject();
			 if ((realUserId > 0) && (userId != realUserId)) { 
			   additionalInfo.put("doAsUserId", String.valueOf(userId)); 
			   additionalInfo.put( "doAsUserName", PortalUtil.getUserName(userId, StringPool.BLANK)); 
			 }else{
				 realUserId = userId;
				 realUserName = userName;
			 }
			 if (attributes != null) { 
			   additionalInfo.put("attributes", _getAttributesJSON(attributes)); 
			 }
			 return new AuditMessage( eventType, companyId, realUserId, realUserName, className, 
			   String.valueOf(classPK), null, additionalInfo); 
			}
	private static JSONArray _getAttributesJSON(List<Attribute> attributes) {
	    JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

	    for (Attribute attribute : attributes) {
	      JSONObject attributeJSONObject = JSONFactoryUtil.createJSONObject();

	      attributeJSONObject.put("name", attribute.getName());
	      attributeJSONObject.put("newValue", attribute.getNewValue());
	      attributeJSONObject.put("oldValue", attribute.getOldValue());

	      jsonArray.put(attributeJSONObject);
	    }

	    return jsonArray;
	  }

}