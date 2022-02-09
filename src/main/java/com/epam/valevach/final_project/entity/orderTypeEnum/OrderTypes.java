package com.epam.valevach.final_project.entity.orderTypeEnum;

public enum OrderTypes {
     RESTORATION(1),
     INSTALLATION(2),
     PRINT(3);
     private int orderTypeId;

     OrderTypes(int orderTypeId) {
          this.orderTypeId = orderTypeId;
     }
}
