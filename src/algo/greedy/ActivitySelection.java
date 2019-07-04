package algo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {

	private List<Activity> activityList;

	public ActivitySelection() {
		activityList = new ArrayList<>();
	}

	public void add(Activity activity) {
		activityList.add(activity);
	}

	public List<Activity> solution() {

		List<Activity> activitySolutionList = new ArrayList<>();

		Comparator<Activity> comparator = new Comparator<Activity>() {

			@Override
			public int compare(Activity o1, Activity o2) {
				return o1.getEndTime() - o2.getEndTime();
			}
		};

		Collections.sort(activityList, comparator);

		Activity lastActivity = activityList.get(0);
		activitySolutionList.add(lastActivity);

		for (int i = 1; i < activityList.size(); i++) {
			Activity currActivity = activityList.get(i);

			if (lastActivity.getEndTime() <= currActivity.getStartTime()) {
				activitySolutionList.add(currActivity);
				lastActivity = currActivity;
			}
		}

		return activitySolutionList;
	}

}
