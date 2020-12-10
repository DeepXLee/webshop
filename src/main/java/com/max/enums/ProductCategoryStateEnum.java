package com.max.enums;

public enum ProductCategoryStateEnum {
	CHECK(0, "审核中"), OFFLINE(-1, "非法商品"), SUCCESS(1, "创建成功"), PASS(2, "通过认证"), INNER_ERROR(-1001, "操作失败"),
	NULL_SHOPID(-1002, "添加数少于1"),EMPTY_LIST(-1003, "类别信息为空");
	private int state;
	private String stateInfo;

	private ProductCategoryStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	/**
	 * 依据传入的state返回相应的enum值
	 */
	public static ProductCategoryStateEnum stateOf(int index) {
		for (ProductCategoryStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

}
