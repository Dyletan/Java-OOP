package practice2;

public class Time implements Comparable<Time>{
	int hour;
	int minute;
	int second;
	
	public Time(){
		this.hour = 0;
		this.minute = 0;
		this.second = 0;
	}
	public Time(int hour){
		this();
		if(checkHour(hour))
			this.hour = hour;
		else {
			giveError();
		}
	}
	public Time(int hour, int minute){
		this(hour);
		if(check(minute)) {
			this.minute = minute;
		}
		else {
			giveError();
		}
	}
	
	public Time(int hour, int minute, int second){
		this(hour, minute);
		if(check(second)) {
			this.second = second;
		}
		else
			giveError();
	}

	private boolean check(int time) {
		if(time >= 0 && time <= 59)
			return true;
		else
			return false;
	}
	private boolean checkHour(int hour) {
		if(hour>=0 && hour <=23) return true;
		else return false;
	}
	private void giveError() {
		System.err.println("Invalid time!!!");
		System.exit(1);
	}
	
	public void setTime(int hour, int minute, int second) {
		if(check(hour) && check(minute) && check(second)) {
			this.hour = hour;
			this.minute = minute;
			this.second = second;
		}
		else
			giveError();
	}
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getSecond() {
		return second;
	}
	public String toUniversal() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
	public String toStandard() {
        int standardHours = hour;
        String period = "AM";

        if (hour == 0) {
            standardHours = 12;
        } else if (hour == 12) {
            period = "PM";
        } else if (hour > 12) {
            standardHours = hour - 12;
            period = "PM";
        }

        return String.format("%02d:%02d:%02d %s", standardHours, minute, second, period);
    }
	public void add(Time other) {
		this.second += other.second;
		int leftMinutes = this.second / 60;
		this.second -= leftMinutes * 60;
		
		this.minute += leftMinutes + other.minute;
		int leftHours = this.minute / 60;
		this.minute -= leftHours * 60;
		
		this.hour += other.hour + leftHours;
		if(!checkHour(this.hour)) {
			this.hour -= 24;
		}
		
	}
	
	public String toString() {
		return toUniversal();
	}
	@Override
	public int compareTo(Time o) {
		if(hour != o.hour) {
			return hour - o.getHour();
		}
		if(minute != o.getMinute()) {
			return minute - o.getMinute();
		}
		return second - o.getSecond();
	}
}
