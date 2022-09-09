package com.app.login.auction.repository;

import com.app.login.auction.entity.ListAuction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListAuctionRepository extends JpaRepository<ListAuction, Integer> {

}
