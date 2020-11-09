package Files;

import java.awt.Point;


public class ArrayPointList implements PointList {
	private Point[] points;
	private int size;
	private int cursor;
	
	public ArrayPointList() {
		this(MAX_SIZE);
	}

	public ArrayPointList(int maxSize) {
		points = new Point[maxSize];
		size = 0;
		cursor = -1;
	}
	
	@Override
	public void append(Point newPoint) {
        points[size] = newPoint;
        size++;
        cursor++;
	}

	@Override
	public void clear() {
        points = new Point[points.length];
        cursor = -1;
        size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean isFull() {
		return size == points.length;
	}

	@Override
	public boolean goToBeginning() {
		if(!isEmpty()) {
			cursor = 0;
			return true;
		}
		return false;
	}

	@Override
	public boolean goToEnd() {
		if(!isEmpty()) {
			cursor = size-1;
			return true;
		}
		return false;
	}

	@Override
	public boolean goToNext() {
		if(cursor != size-1 && size != 0) {
			cursor++;
			return true;
		}
		return false;
	}

	@Override
	public boolean goToPrior() {
		if(!isEmpty() && cursor != 0) {
			cursor--;
			return true;
		}
		return false;
	}

	@Override
	public Point getCursor() {
		if(isEmpty()) return null;
		return new Point(points[cursor].x , points[cursor].y);
	}

	@Override
	public String toString() {
		if(isEmpty()) return "Empty list";
		StringBuilder str = new StringBuilder();
		for(Point p : points) {
			str.append(p.toString());
		}
		return str.toString();
	}

}
