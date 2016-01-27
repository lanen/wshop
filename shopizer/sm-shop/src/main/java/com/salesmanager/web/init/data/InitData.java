package com.salesmanager.web.init.data;

import com.salesmanager.core.business.generic.exception.ServiceException;

/**
 *
 * 初始化数据库数据
 *
 */
public interface InitData {

	void initInitialData() throws ServiceException;

}
