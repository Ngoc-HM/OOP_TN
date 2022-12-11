//Họ Và Tên: Hoàng Minh Ngọc 20200440
//Mã lớp TH: 721427

package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        if (o1.getTitle().equals(o2.getTitle())) {
            return Float.compare(o1.getCost(), o2.getCost());
        }
        return o1.getTitle().compareTo(o2.getTitle());
    }
}

