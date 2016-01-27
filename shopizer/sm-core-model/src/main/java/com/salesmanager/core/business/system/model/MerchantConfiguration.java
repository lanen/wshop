package com.salesmanager.core.business.system.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.salesmanager.core.business.common.model.audit.AuditListener;
import com.salesmanager.core.business.common.model.audit.AuditSection;
import com.salesmanager.core.business.common.model.audit.Auditable;
import com.salesmanager.core.business.generic.model.SalesManagerEntity;
import com.salesmanager.core.business.merchant.model.MerchantStore;
import com.salesmanager.core.constants.SchemaConstant;

/**
 * Merchant configuration information
 * @author Carl Samson
 *
 */
@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "MERCHANT_CONFIGURATION", schema= SchemaConstant.SALESMANAGER_SCHEMA, uniqueConstraints=
	@UniqueConstraint(columnNames = {"MERCHANT_ID", "CONFIG_KEY"}))
public class MerchantConfiguration extends SalesManagerEntity<Long, MerchantConfiguration> implements Serializable, Auditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4246917986731953459L;

	@Id
	@Column(name = "MERCHANT_CONFIG_ID")
	@TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "MERCH_CONF_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="MERCHANT_ID", nullable=true)
	private MerchantStore merchantStore;
	
	@Embedded
	private AuditSection auditSection = new AuditSection();
	
	@Column(name="CONFIG_KEY")
	private String key;

	@Lob
	@Column(name="VALUE")
//	@Type(type = "org.hibernate.type.StringClobType")
	private String value;
	
	@Column(name="TYPE")
	@Enumerated(value = EnumType.STRING)
	private MerchantConfigurationType merchantConfigurationType = MerchantConfigurationType.INTEGRATION;

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public AuditSection getAuditSection() {
		return auditSection;
	}

	public void setAuditSection(AuditSection auditSection) {
		this.auditSection = auditSection;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}



	public MerchantStore getMerchantStore() {
		return merchantStore;
	}

	public void setMerchantStore(MerchantStore merchantStore) {
		this.merchantStore = merchantStore;
	}

	public void setMerchantConfigurationType(MerchantConfigurationType merchantConfigurationType) {
		this.merchantConfigurationType = merchantConfigurationType;
	}

	public MerchantConfigurationType getMerchantConfigurationType() {
		return merchantConfigurationType;
	}


}
