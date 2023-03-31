package com.heyufei.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 博客标签
 * @author Administrator
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="tag")
public class Tag implements Serializable{
	    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;//

	@Column(name = "tag_name")
	private String tagName;//
	private String color;//标签颜色(可选)

}
