package com.o2o.enums;

public enum ProductCategoryStateEnum {
	SUCCESS(1, "创建成功"), INNER_ERROR(-1001, "操作失败"), EMPTY_LIST(-1002, "添加数少于1");

	private int state;

	private String stateInfo;

	private ProductCategoryStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static com.o2o.enums.ProductCategoryStateEnum stateOf(int index) {
		for (com.o2o.enums.ProductCategoryStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}
