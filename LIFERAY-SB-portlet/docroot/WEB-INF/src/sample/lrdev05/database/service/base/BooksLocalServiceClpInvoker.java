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

package sample.lrdev05.database.service.base;

import sample.lrdev05.database.service.BooksLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class BooksLocalServiceClpInvoker {
	public BooksLocalServiceClpInvoker() {
		_methodName0 = "addBooks";

		_methodParameterTypes0 = new String[] {
				"sample.lrdev05.database.model.Books"
			};

		_methodName1 = "createBooks";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteBooks";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteBooks";

		_methodParameterTypes3 = new String[] {
				"sample.lrdev05.database.model.Books"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "fetchBooks";

		_methodParameterTypes9 = new String[] { "long" };

		_methodName10 = "getBooks";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getBooksByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getBookses";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getBooksesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateBooks";

		_methodParameterTypes15 = new String[] {
				"sample.lrdev05.database.model.Books"
			};

		_methodName16 = "updateBooks";

		_methodParameterTypes16 = new String[] {
				"sample.lrdev05.database.model.Books", "boolean"
			};

		_methodName51 = "getBeanIdentifier";

		_methodParameterTypes51 = new String[] {  };

		_methodName52 = "setBeanIdentifier";

		_methodParameterTypes52 = new String[] { "java.lang.String" };

		_methodName57 = "addBooks";

		_methodParameterTypes57 = new String[] {
				"sample.lrdev05.database.model.Books", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName58 = "updateStatus";

		_methodParameterTypes58 = new String[] {
				"long", "long", "int",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName59 = "getBooksInstance";

		_methodParameterTypes59 = new String[] {  };

		_methodName60 = "getAllBooks";

		_methodParameterTypes60 = new String[] { "long" };

		_methodName61 = "getAllBooks";

		_methodParameterTypes61 = new String[] {  };

		_methodName62 = "getAllBooks";

		_methodParameterTypes62 = new String[] { "long", "java.lang.String" };

		_methodName63 = "getBooksByUserId";

		_methodParameterTypes63 = new String[] { "long" };

		_methodName64 = "deleteBooks";

		_methodParameterTypes64 = new String[] { "long", "long" };

		_methodName65 = "deleteBooks";

		_methodParameterTypes65 = new String[] {
				"sample.lrdev05.database.model.Books", "long"
			};

		_methodName66 = "getBooks";

		_methodParameterTypes66 = new String[] { "long" };

		_methodName67 = "getLatestBook";

		_methodParameterTypes67 = new String[] { "long", "int" };

		_methodName68 = "updateBooks";

		_methodParameterTypes68 = new String[] {
				"sample.lrdev05.database.model.Books", "long"
			};

		_methodName70 = "updateMyBean";

		_methodParameterTypes70 = new String[] {
				"sample.lrdev05.database.model.Books",
				"sample.lrdev05.database.model.Books"
			};

		_methodName72 = "buildAuditMessage";

		_methodParameterTypes72 = new String[] {
				"java.lang.String", "java.lang.String", "long", "java.util.List"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return BooksLocalServiceUtil.addBooks((sample.lrdev05.database.model.Books)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return BooksLocalServiceUtil.createBooks(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return BooksLocalServiceUtil.deleteBooks(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return BooksLocalServiceUtil.deleteBooks((sample.lrdev05.database.model.Books)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return BooksLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return BooksLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return BooksLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return BooksLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return BooksLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return BooksLocalServiceUtil.fetchBooks(((Long)arguments[0]).longValue());
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return BooksLocalServiceUtil.getBooks(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return BooksLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return BooksLocalServiceUtil.getBooksByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return BooksLocalServiceUtil.getBookses(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return BooksLocalServiceUtil.getBooksesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return BooksLocalServiceUtil.updateBooks((sample.lrdev05.database.model.Books)arguments[0]);
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return BooksLocalServiceUtil.updateBooks((sample.lrdev05.database.model.Books)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			return BooksLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			BooksLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return BooksLocalServiceUtil.addBooks((sample.lrdev05.database.model.Books)arguments[0],
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return BooksLocalServiceUtil.updateStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return BooksLocalServiceUtil.getBooksInstance();
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return BooksLocalServiceUtil.getAllBooks(((Long)arguments[0]).longValue());
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return BooksLocalServiceUtil.getAllBooks();
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return BooksLocalServiceUtil.getAllBooks(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return BooksLocalServiceUtil.getBooksByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			BooksLocalServiceUtil.deleteBooks(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			BooksLocalServiceUtil.deleteBooks((sample.lrdev05.database.model.Books)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return BooksLocalServiceUtil.getBooks(((Long)arguments[0]).longValue());
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return BooksLocalServiceUtil.getLatestBook(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return BooksLocalServiceUtil.updateBooks((sample.lrdev05.database.model.Books)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			BooksLocalServiceUtil.updateMyBean((sample.lrdev05.database.model.Books)arguments[0],
				(sample.lrdev05.database.model.Books)arguments[1]);
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return BooksLocalServiceUtil.buildAuditMessage((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.util.List<com.liferay.portal.audit.hook.listeners.util.Attribute>)arguments[3]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName72;
	private String[] _methodParameterTypes72;
}