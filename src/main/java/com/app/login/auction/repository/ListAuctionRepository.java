package com.app.login.auction.repository;

import com.app.login.auction.entity.ListAuction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ListAuctionRepository extends JpaRepository<ListAuction, Integer> {
	

	@Query(value="select * from list_auction where video_1 IS NOT NULL || video_2 IS NOT NULL",nativeQuery=true)
	List<ListAuction> getVideoNotNull();

}
