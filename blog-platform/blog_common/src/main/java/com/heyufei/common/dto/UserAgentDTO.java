package com.heyufei.common.dto;

import lombok.*;

/**
 * UserAgent解析DTO
 *
 * @author HeYuFei
 * @since 2023-03-31  14:17
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserAgentDTO {
    private String os;
    private String browser;
}