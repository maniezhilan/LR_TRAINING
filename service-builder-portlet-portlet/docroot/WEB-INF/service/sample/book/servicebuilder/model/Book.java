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

package sample.book.servicebuilder.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Book service. Represents a row in the &quot;servicebuilder_Book&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see BookModel
 * @see sample.book.servicebuilder.model.impl.BookImpl
 * @see sample.book.servicebuilder.model.impl.BookModelImpl
 * @generated
 */
public interface Book extends BookModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link sample.book.servicebuilder.model.impl.BookImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
}