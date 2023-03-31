package com.heyufei.user.entity;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description: 城市访客数量
 * @Author: Naccl
 * @Date: 2021-02-26
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "city_visitor")
public class CityVisitor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private String city;//城市名称
	private Integer uv;//独立访客数量
}
