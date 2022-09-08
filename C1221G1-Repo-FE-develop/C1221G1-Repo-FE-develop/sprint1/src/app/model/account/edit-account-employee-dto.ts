import {Position} from "../employee/position";

export interface EditAccountEmployeeDto {
  employeeId?: string;
  employeeName?: string;
  positionName?: string;
  username?: string;
  password?: string;
}
