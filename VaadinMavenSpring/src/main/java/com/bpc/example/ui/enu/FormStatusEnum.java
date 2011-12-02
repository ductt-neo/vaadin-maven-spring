package com.bpc.example.ui.enu;

public enum FormStatusEnum {
   ADD("add"), EDIT("edit"), DISCARD("discard");

   private String type;

   private FormStatusEnum(String type) {
      this.type = type;
   }

   public String getType() {
      return type;
   }

}
