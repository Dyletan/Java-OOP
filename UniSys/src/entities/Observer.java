package entities;

import messages.Notification;

public interface Observer {
	void notifyNewPaper(Notification notification);
}
