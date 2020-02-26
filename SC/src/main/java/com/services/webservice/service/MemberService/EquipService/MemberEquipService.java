package com.services.webservice.service.MemberService.EquipService;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.webservice.domain.EState;
import com.services.webservice.domain.Equipment.EquipState;
import com.services.webservice.domain.Equipment.EquipStateRepository;
import com.services.webservice.domain.Equipment.Equipment;
import com.services.webservice.domain.Equipment.EquipmentRepository;
import com.services.webservice.domain.Member.Member;
import com.services.webservice.domain.Member.MemberRepository;
import com.services.webservice.domain.RentalLog.EquipRentalLogRepository;
import com.services.webservice.service.dto.Equip.Request.ReqEquipRentalDto;
import com.services.webservice.service.dto.Equip.Request.ReqEquipReturnDto;
import com.services.webservice.service.dto.Equip.Response.ResEquipListDto;
import com.services.webservice.service.dto.Equip.Save.SaveEquipRentalDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MemberEquipService {

	@Autowired
	private MemberRepository memberRepo;

	@Autowired
	private EquipmentRepository equipRepo;

	@Autowired
	private EquipRentalLogRepository equipLogRepo;
	
	@Autowired
	private EquipStateRepository equipStateRepo;

	public List<ResEquipListDto> selectEuqipList() {
		return equipRepo.findAllbyOrderByDesc()
				.stream()
				.map(ResEquipListDto::new)
				.collect(Collectors.toList());
	}

	public void executeEquipRental(ReqEquipRentalDto dto) throws NullPointerException {
		// 이 사람이 이 물건과 같은 물건을 빌린 적이 있는지
		if (equipLogRepo.findByMemberRentalSameEquipCount(dto.getStudentNum(), dto.getEquipName()) > 0) {
			// Message: 이미 같은 기자재를 빌리는 중입니다.		
		} 
		else {
			saveEquipmentRentalLog(dto);
			//Message: 완료되었습니다.
		}
	}

	@Transactional
	private void saveEquipmentRentalLog(ReqEquipRentalDto dto) throws NullPointerException{
			//1. 사람이 있는지
			Member member = memberRepo.findByStudentNum(dto.getStudentNum());
			
			//2. 있는 물건인지 & 물건상태는 어떤지
			Equipment equipment = equipRepo.findByEquipNum(dto.getEquipNum());
			
			//3. 기자재 렌탈 테이블에 정보 저장
			equipLogRepo.save(SaveEquipRentalDto.builder()
					.memberId(member)
					.equipId(equipment)
					.rentalTime(dto.getRentalTime())
					.predictReturnTime(dto.getPredictReturnTime())
					.reason(dto.getReason())
					.build()
					.toEntity());
			
			//기자재 테이블에 렌탈여부 업데이트
			equipRepo.updatebyRentalEquip(dto.getEquipNum(), equipStateRepo.findByState(EState.USE.getValue()));
//			equip.setReturn(false);
//			equip.setEquipStateId(equipStateRepo.findByState(EState.USE.getValue()));
//			equipRepo.save(equip);
	}
	
	public boolean isReturnEquip() {
//		렌탈 반납
		return false;
	}

}