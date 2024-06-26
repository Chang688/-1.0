package com.niuma.langbei.model.dto.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author changwei
 * @create 2022-09-10 15:55
 */
@Data
public class TeamQuitRequest implements Serializable {

    private static final long serialVersionUID = 1950536713854398674L;
    /**
     * id
     */
    private Long teamId;

}
