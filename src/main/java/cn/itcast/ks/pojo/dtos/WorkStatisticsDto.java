package cn.itcast.ks.pojo.dtos;

import lombok.Data;

import java.util.Date;

/**
 * @author FF
 * @date 2021/12/8
 * @TIME:10:12
 */
@Data
public class WorkStatisticsDto {

   private Integer classId;
   private Date endTime;
   private Date startTime;
   private Integer type;

}
