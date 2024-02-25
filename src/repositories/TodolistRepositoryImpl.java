package repositories;

import entities.Todolist;

public class TodolistRepositoryImpl implements TodolistRepository {
    public static Todolist[] model = new Todolist[10];

    @Override
    public Todolist[] getAll() {
        return model;
    }

    @Override
    public void add(Todolist todolist) {
        // cek apakah model penuh ?
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        //jika penuh, kita resize ukuran array 2 kali lipat
        if (isFull) {
            var temp = model;
            model = new Todolist[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // Tambahkan ke posisi yang data array nya NULL
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todolist;
                break;
            }
        }
    }

    @Override
    public Boolean remove(Integer number, Boolean isNumberId) {
        // check whether the selected todo is 0
        if (number == 0) {
            return false;
        }
        // check whether the selected todo is greater than the current size of the model
        if (number - 1 > model.length - 1) {
            return false;
        }

        // check whether the selected todo is already null
        if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = number - 1; i < model.length; i++) {
                //if the selected id is the last element
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    // replace the current element with the element beside it
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }
}
