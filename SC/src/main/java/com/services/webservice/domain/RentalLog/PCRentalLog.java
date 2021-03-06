package com.services.webservice.domain.RentalLog;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.services.webservice.domain.Equipment.Computer;
import com.services.webservice.domain.Member.Member;
import com.services.webservice.library.entity.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "PCRENTALLOG")
public class PCRentalLog extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(targetEntity = Member.class, fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, foreignKey = @ForeignKey(name = "fk_user_ide"))
	private Member member;

	@ManyToOne(targetEntity = Computer.class, fetch = FetchType.EAGER)
	@JoinColumn(updatable = false, foreignKey = @ForeignKey(name = "fk_computer_idf"))
	private Computer pc;

	@Column(nullable = false)
	private LocalDateTime rentalTime;

	@Column(nullable = false)
	private LocalDateTime predictReturnTime;

	@Column(nullable = true)
	private LocalDateTime realReturnTime;

	@Column(nullable = true)
	private String reason;

	@Column(columnDefinition = "boolean")
	private boolean isOverdue;

	@Builder
	public PCRentalLog(Long id, Member member, Computer pc, LocalDateTime rentalTime, LocalDateTime predictReturnTime,
			LocalDateTime realReturnTime, String reason, boolean isOverdue) {
		this.id = id;
		this.member = member;
		this.pc = pc;
		this.rentalTime = rentalTime;
		this.predictReturnTime = predictReturnTime;
		this.realReturnTime = realReturnTime;
		this.reason = reason;
		this.isOverdue = isOverdue;
	}
}
