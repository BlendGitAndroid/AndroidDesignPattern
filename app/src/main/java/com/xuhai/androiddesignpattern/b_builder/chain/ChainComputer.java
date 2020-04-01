package com.xuhai.androiddesignpattern.b_builder.chain;

import androidx.annotation.NonNull;

public class ChainComputer {


    private String mBoard;
    private String mDisplay;
    private String mOS;

    @NonNull
    @Override
    public String toString() {
        return "Computer [mBoard=" + mBoard + ",mDisplay=" + mDisplay + ",mOS" + mOS + "]";
    }

    public static final class ChainBuilder {
        private String board = "中国主板";
        private String display = "中国显示器";
        private String os = "中国系统";

        public ChainComputer.ChainBuilder setBoard(String board) {
            this.board = board;
            return this;
        }

        public ChainComputer.ChainBuilder setDisplay(String display) {
            this.display = display;
            return this;
        }


        public ChainComputer.ChainBuilder setOs(String os) {
            this.os = os;
            return this;
        }

        private void construct(ChainComputer computer) {
            computer.mBoard = board;
            computer.mDisplay = display;
            computer.mOS = os;
        }

        public ChainComputer build() {
            ChainComputer computer = new ChainComputer();
            construct(computer);
            return computer;
        }
    }
}
