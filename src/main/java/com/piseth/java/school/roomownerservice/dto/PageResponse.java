package com.piseth.java.school.roomownerservice.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * Generic page response for REST APIs.
 *
 * @param <T> the type of items contained in the page
 */
@Data
@Builder
public class PageResponse<T> {
  
  /** Current page number (0-based). */
  private int page;

  /** Page size (number of items per page). */
  private int size;

  /** Total number of elements across all pages. */
  private long totalElements;

  /** Total number of pages. */
  private int totalPages;

  /** The actual list of items. */
  private List<T> items;
}
