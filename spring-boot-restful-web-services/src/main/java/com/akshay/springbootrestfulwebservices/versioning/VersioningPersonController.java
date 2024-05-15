package com.akshay.springbootrestfulwebservices.versioning;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    // URI versioning.

    @GetMapping("v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Akshay");
    }

    @GetMapping("v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Akshay", "Hulkuli"));
    }


    // Query param / Request param versioning

    // Way 1.
    @GetMapping("person")
    public ResponseEntity<?> getPersonBasedOnRequestParams(@RequestParam String version) {
        if(version.equals("v1")) {
            return new ResponseEntity<>(new PersonV1("Akshay"), HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(new PersonV2(new Name("Akshay", "Hulkuli")), HttpStatus.OK);
        }
    }

    //Way 2
    @GetMapping(path = "person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonUsingRequestParam() {
        return new PersonV1("Akshay");
    }

    @GetMapping(path = "person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonUsingRequestParam() {
        return new PersonV2(new Name("Akshay", "Hulkuli"));
    }

    // Using HTTP Request Header
    @GetMapping(path = "person", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonUsingHeader() {
        return new PersonV1("Akshay");
    }

    @GetMapping(path = "person", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonUsingHeader() {
        return new PersonV2(new Name("Akshay", "Hulkuli"));
    }

    // Using content negotiation (Accept header)
    @GetMapping(path = "person", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonUsingContentNegotiation() {
        return new PersonV1("Akshay");
    }

    @GetMapping(path = "person", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonUsingContentNegotiation() {
        return new PersonV2(new Name("Akshay", "Hulkuli"));
    }


}
