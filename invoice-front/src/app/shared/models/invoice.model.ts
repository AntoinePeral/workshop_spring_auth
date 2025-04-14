import { User } from "./user.model";

export interface Invoice {
  id?: number;
  description: string;
  amount: number;
  date: string | Date;
  user?: User;
}