package org.boss.cart.model.cart.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class GoodsDTO implements Serializable {

    private long Id;

    private String name;

    private String size;

    private int number;

    private String purpose;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;

}
