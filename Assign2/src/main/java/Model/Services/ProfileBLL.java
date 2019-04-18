package Model.Services;

import Model.Repository.ProfileDao;
import Model.entity.StudentData;
import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.*;

public class ProfileBLL {
    public static List<StudentData> viewProfile()
    {

        return ProfileDao.View();
    }
    public static ObservableList view2(ArrayList<StudentData> obj)
    {
        ObservableList s=new ObservableList() {
            public void addListener(ListChangeListener listener) {

            }

            public void removeListener(ListChangeListener listener) {

            }

            public boolean addAll(Object[] elements) {
                return false;
            }

            public boolean setAll(Object[] elements) {
                return false;
            }

            public boolean setAll(Collection col) {
                return false;
            }

            public boolean removeAll(Object[] elements) {
                return false;
            }

            public boolean retainAll(Object[] elements) {
                return false;
            }

            public void remove(int from, int to) {

            }

            public int size() {
                return 0;
            }

            public boolean isEmpty() {
                return false;
            }

            public boolean contains(Object o) {
                return false;
            }

            public Iterator iterator() {
                return null;
            }

            public Object[] toArray() {
                return new Object[0];
            }

            public Object[] toArray(Object[] a) {
                return new Object[0];
            }

            public boolean add(Object o) {
                return false;
            }

            public boolean remove(Object o) {
                return false;
            }

            public boolean containsAll(Collection c) {
                return false;
            }

            public boolean addAll(Collection c) {
                return false;
            }

            public boolean addAll(int index, Collection c) {
                return false;
            }

            public boolean removeAll(Collection c) {
                return false;
            }

            public boolean retainAll(Collection c) {
                return false;
            }

            public void clear() {

            }

            public Object get(int index) {
                return null;
            }

            public Object set(int index, Object element) {
                return null;
            }

            public void add(int index, Object element) {

            }

            public Object remove(int index) {
                return null;
            }

            public int indexOf(Object o) {
                return 0;
            }

            public int lastIndexOf(Object o) {
                return 0;
            }

            public ListIterator listIterator() {
                return null;
            }

            public ListIterator listIterator(int index) {
                return null;
            }

            public List subList(int fromIndex, int toIndex) {
                return null;
            }

            public void addListener(InvalidationListener listener) {

            }

            public void removeListener(InvalidationListener listener) {

            }
        };
        s.add(((StudentData)obj.get(0)).getID());
        s.add(((StudentData)obj.get(0)).getName());
        s.add(((StudentData)obj.get(0)).getGrupa());
        return s;
    }

}
