package com.in28minutes.webservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	@GetMapping("v1/person")
	public PersonV1 personv1() {
		return new PersonV1("Bob Charlie");
	}
	@GetMapping("v2/person")
	public PersonV2 personv2() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	
	@GetMapping(value="/person/param", params="version=1")
	public PersonV1 paramv1() {
		return new PersonV1("Bob Charlie");
	}
	@GetMapping(value="/person/param", params ="version=2")
	public PersonV2 paramv2() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	@GetMapping(value="/person/header", headers="X-API-VERSION=1")
	public PersonV1 headerv1() {
		return new PersonV1("Bob Charlie");
	}
	@GetMapping(value="/person/header", headers  ="X-API-VERSION=2")
	public PersonV2 headerv2() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	
	@GetMapping(value="/person/produces", produces   ="application/vnd.company.api-v1+json")
	public PersonV1 producesv1() {
		return new PersonV1("Bob Charlie");
	}
	@GetMapping(value="/person/produces", produces   ="application/vnd.company.api-v2+json")
	public PersonV2 producesv2() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	

}
