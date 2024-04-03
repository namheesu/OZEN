package kr.or.ddit.global.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "{mbti, recomSeason, recomAge, recomRank}")
public class RecomSbrsVO {
	private String sbrsCd;
	private String mbti;
	private String recomSeason;
	private String recomAge;
	private Integer recomRank;
}
