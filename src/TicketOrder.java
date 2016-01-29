
public class TicketOrder {

	private int TicketBalance;
	final int MAX_TIX = 6;
	private String errorMsg = "";

	public TicketOrder(int t) {
		this.TicketBalance = t;

	}

	public int TicketBalance() {
		return TicketBalance;

	}

	public int getTicketBalance() {
		return TicketBalance;
	}

	public void setTicketBalance(int TicketBalance) {
		this.TicketBalance = TicketBalance;
	}

	public int getMAX_TIX() {
		return MAX_TIX;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public void decreaseTicket(int t) {
		this.setErrorMsg("");
		if (t < 1) {
			this.setErrorMsg("You must enter a valid number up to 6.");
		} else {
			if (t > MAX_TIX) {
				this.setErrorMsg("Please enter a value of 6 or less.");
			} else {

				if (t > this.TicketBalance) {
					this.setErrorMsg("There are only " + this.getTicketBalance() + " tickets left.");
				} else {

					this.setTicketBalance(this.getTicketBalance() - t);
					this.setErrorMsg(t + " tickets purchased. " + this.getTicketBalance() + " tickets remaining.");
				}
			}
		}
	}
}
