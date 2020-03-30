package com.services.webservice.microService.equipment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.webservice.library.dto.RestResponseBaseDto;
import com.services.webservice.microService.equipment.dto.request.ReqEquipRentalDto;
import com.services.webservice.microService.equipment.dto.request.ReqEquipReturnDto;
import com.services.webservice.microService.equipment.service.EquipService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/member/equip")
public class EquipRestController {

	@Autowired
	private EquipService service;
	
	@PostMapping("/rent")
	public RestResponseBaseDto equipRent(@RequestBody ReqEquipRentalDto dto) throws Exception{
		if(service.equipRent(dto)) {
			return RestResponseBaseDto.builder()
				.result(true)
				.msg("Success")
				.build();
		}else {
			return RestResponseBaseDto.builder()
				.result(false)
				.msg("이미 같은 종류의 기자재를 빌리고 있습니다.")
				.build();
		}
	}

	@PostMapping("/return")
	public RestResponseBaseDto<?> equipRetrun(@RequestBody @Valid ReqEquipReturnDto dto) {
		if(service.equipReturn(dto)) {
			return RestResponseBaseDto.builder()
					.result(true)
					.msg("Success")
					.build();
		}
		else {
			return RestResponseBaseDto.builder()
					.result(false)
					.msg("빌린 물품이 없습니다.")
					.build();
		}
	}
}
