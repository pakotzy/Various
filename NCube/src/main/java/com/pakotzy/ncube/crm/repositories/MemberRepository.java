package com.pakotzy.ncube.crm.repositories;

import com.pakotzy.ncube.crm.entities.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends MongoRepository<Member, String> {
}
