package me.tr.trlogger.loggers.file.changers;

import java.io.File;

public interface Changer {

    boolean start(File file);

    boolean stop(File file);

    void change(File file);


    Changer EMPTY = new Changer() {
        @Override
        public boolean start(File file) {
            return false;
        }
        @Override
        public boolean stop(File file) {
            return false;
        }
        @Override
        public void change(File file) {

        }
    };
}
