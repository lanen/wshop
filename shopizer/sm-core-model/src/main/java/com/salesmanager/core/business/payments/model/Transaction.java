package com.salesmanager.core.business.payments.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.annotations.Type;
import org.json.simple.JSONAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.salesmanager.core.business.common.model.audit.AuditListener;
import com.salesmanager.core.business.common.model.audit.AuditSection;
import com.salesmanager.core.business.common.model.audit.Auditable;
import com.salesmanager.core.business.generic.model.SalesManagerEntity;
import com.salesmanager.core.business.order.model.Order;
import com.salesmanager.core.constants.SchemaConstant;


@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "SM_TRANSACTION", schema= SchemaConstant.SALESMANAGER_SCHEMA)
public class Transaction extends SalesManagerEntity<Long, Transaction> implements Serializable, Auditable, JSONAware {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Transaction.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TRANSACTION_ID")
	@TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "TRANSACT_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id;
	
	@Embedded
	private AuditSection auditSection = new AuditSection();

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ORDER_ID", nullable=true)
	private Order order;
	
	@Column(name="AMOUNT")
	private BigDecimal amount;
	
	@Column(name="TRANSACTION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	
	@Column(name="TRANSACTION_TYPE")
	@Enumerated(value = EnumType.STRING)
	private TransactionType transactionType;
	
	@Column(name="PAYMENT_TYPE")
	@Enumerated(value = EnumType.STRING)
	private PaymentType paymentType;

	@Lob
	@Column(name="DETAILS")
	//@Type(type = "org.hibernate.type.StringClobType")
	private String details;
	
	@Transient
	private Map<String,String> transactionDetails= new HashMap<String,String>();

	@Override
	public AuditSection getAuditSection() {
		return this.auditSection;
	}

	@Override
	public void setAuditSection(AuditSection audit) {
		this.auditSection = audit;
		
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Map<String, String> getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(Map<String, String> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	@Override
	public String toJSONString() {
		
		if(this.getTransactionDetails()!=null && this.getTransactionDetails().size()>0) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				return mapper.writeValueAsString(this.getTransactionDetails());
			} catch (Exception e) {
				LOGGER.error("Cannot parse transactions map",e);
			}
			
		}
		
		return null;
	}

}
