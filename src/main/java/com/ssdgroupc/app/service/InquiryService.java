package com.ssdgroupc.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssdgroupc.app.entity.Inquiry;
import com.ssdgroupc.app.repository.InquiryRepository;
@Service
public class InquiryService {

	/**
	 * Injects InquiryRepository
	 */
	@Autowired
	private InquiryRepository inquiryRepository;

	/**
	 * Method to get all inquiries
	 */
	public List<Inquiry> getAllInquires() {
		List<Inquiry> inquiries = new ArrayList<>();
		inquiryRepository.findAll().forEach(inquiries::add);
		return inquiries;
	}
	
	/**
	 * Method to Update an Inquiry
	 */
	public Inquiry updateInquiry(int id, Inquiry inquiry) {
		return inquiryRepository.save(inquiry);
	}
	
	/**
	 * Method to delete an Inquiry
	 */
	public void deleteInquiry(int id) {
		inquiryRepository.deleteById(id);
	}
	
	/**
	 * Method to save an Inquiry
	 */
	public Inquiry addInquiry(Inquiry inquiry) {
		return inquiryRepository.save(inquiry);
	}

}
