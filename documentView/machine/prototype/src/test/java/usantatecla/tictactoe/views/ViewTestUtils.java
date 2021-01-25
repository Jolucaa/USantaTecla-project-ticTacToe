package usantatecla.tictactoe.views;

import java.util.List;

class ViewTestUtils {

    String arrayToString(Object[] stringArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            stringBuilder.append(stringArray[i]);
        }
        return stringBuilder.toString();
    }

    void reorder(List<String> list) {
        list.add(list.size() - 1, list.remove(1));
    }

}
