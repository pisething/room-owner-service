package com.piseth.java.school.roomservice.service.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;

import com.piseth.java.school.roomownerservice.dto.RoomFilterDTO;
import com.piseth.java.school.roomownerservice.util.RoomConstants;
import com.piseth.java.school.roomownerservice.util.RoomCriteriaBuilder;

public class RoomCriteriaBuilderTest {
	/*
	@Test
	void shouldReturnEmptyCriteria_whenNoFilterProvided() {
		// given
		RoomFilterDTO filter = new RoomFilterDTO();
		// when
		Criteria criteria = RoomCriteriaBuilder.build(filter);
		// then
		assertThat(criteria.getCriteriaObject()).isEmpty();
	}
	
	@Test
	void shouldAddNameCriteria_whenNameProvided() {
		// given
		RoomFilterDTO filter = new RoomFilterDTO();
		filter.setName("Luxury Room");
		// when
		Criteria criteria = RoomCriteriaBuilder.build(filter);
		String json = criteria.getCriteriaObject().toJson();
		// then
		assertThat(json).contains("name", "Luxury Room");
	}
	
	@Test
	void shouldAddFloorCriteria_whenFloorProvided() {
		// given
		RoomFilterDTO filter = new RoomFilterDTO();
		filter.setFloor(2);
		// when
		Criteria criteria = RoomCriteriaBuilder.build(filter);
		String json = criteria.getCriteriaObject().toJson();
		// then
		assertThat(json).contains("floor", "2");
	}
	
	@Test
	void shouldAddPriceCriteria_withOperationLT() {
		// given
		RoomFilterDTO filter = new RoomFilterDTO();
		filter.setPrice(60d);
		filter.setPriceOp("lt");
		// when
		Criteria criteria = RoomCriteriaBuilder.build(filter);
		String json = criteria.getCriteriaObject().toJson();
		// then
		assertThat(json).contains("price").contains("$lt"); 
	}
	
	@Test
	void shouldAddPriceCriteria_withOperationLTE() {
		// given
		RoomFilterDTO filter = new RoomFilterDTO();
		filter.setPrice(60d);
		filter.setPriceOp("lte");
		// when
		Criteria criteria = RoomCriteriaBuilder.build(filter);
		String json = criteria.getCriteriaObject().toJson();
		// then
		assertThat(json).contains("price").contains("$lte"); 
	}
	
	@Test
	void shouldAddPriceCriteria_withOperationGT() {
		// given
		RoomFilterDTO filter = new RoomFilterDTO();
		filter.setPrice(60d);
		filter.setPriceOp("gt");
		// when
		Criteria criteria = RoomCriteriaBuilder.build(filter);
		String json = criteria.getCriteriaObject().toJson();
		// then
		assertThat(json).contains("price").contains("$gt"); 
	}
	
	@Test
	void shouldAddPriceCriteria_withOperationGTE() {
		// given
		RoomFilterDTO filter = new RoomFilterDTO();
		filter.setPrice(60d);
		filter.setPriceOp("gte");
		// when
		Criteria criteria = RoomCriteriaBuilder.build(filter);
		String json = criteria.getCriteriaObject().toJson();
		// then
		assertThat(json).contains("price").contains("$gte"); 
	}
	
	@Test
	void shouldAddPriceCriteria_withOperationEQ() {
		// given
		RoomFilterDTO filter = new RoomFilterDTO();
		filter.setPrice(60d);
		filter.setPriceOp("eq");
		// when
		Criteria criteria = RoomCriteriaBuilder.build(filter);
		String json = criteria.getCriteriaObject().toJson();
		// then
		assertThat(json).contains("price").contains("60"); 
	}
	
	@Test
	void shouldAddPriceMin_PriceMax() {
		// given
		RoomFilterDTO filter = new RoomFilterDTO();
		filter.setPriceMin(60d);
		filter.setPriceMax(80d);
		// when
		Criteria criteria = RoomCriteriaBuilder.build(filter);
		String json = criteria.getCriteriaObject().toJson();
		// then
		assertThat(json).contains("price").contains("$gte").contains("$lte"); 
	}
	
	// Sort
	
	@Test
	public void sort_withValidFieldASC() {
		// given
		RoomFilterDTO filter = new RoomFilterDTO();
		filter.setDirection("asc");
		filter.setSortBy("price");
		// when
		Sort sort = RoomCriteriaBuilder.sort(filter);
		// then
		assertThat(sort.getOrderFor("attributes.price")).isNotNull();
		assertThat(sort.getOrderFor("attributes.price").getDirection())
				.isEqualTo(Sort.Direction.ASC);
		
	}
	
	@Test
	void sort_withInvalidField_throwException() {
		// given
		RoomFilterDTO filter = new RoomFilterDTO();
		filter.setDirection("asc");
		filter.setSortBy("type"); // type is invalid field
		
		// when		
		assertThatThrownBy(() -> RoomCriteriaBuilder.sort(filter))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("Invalid sort fiels");
	}
	
	@Test
	void sort_withDefaultValue() {
		// given
		RoomFilterDTO filter = new RoomFilterDTO(); // no sortBy or direction
		
		// when
		Sort sort = RoomCriteriaBuilder.sort(filter);
		// then
		assertThat(sort.getOrderFor("name")).isNotNull();
		assertThat(sort.getOrderFor("name").getDirection())
			.isEqualTo(Sort.Direction.ASC);
	}
	
	@Test
	void sort_withDirectionDESC() {
		// given
		RoomFilterDTO filter = new RoomFilterDTO(); // no sortBy or direction
		filter.setDirection("desc");
		// when
		Sort sort = RoomCriteriaBuilder.sort(filter);
		// then
		assertThat(sort.getOrderFor("name")).isNotNull();
		assertThat(sort.getOrderFor("name").getDirection())
			.isEqualTo(Sort.Direction.DESC);
	}
	*/
}
