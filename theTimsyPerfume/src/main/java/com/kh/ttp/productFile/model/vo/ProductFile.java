package com.kh.ttp.productFile.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class ProductFile {
	private int pdtFileNo;
	private int pdtNo;
	private int pdtFileIndex;
	private String pdtFilePath;
	private String pdtFileOrigin;
	private String pdtFileUpload;

}
