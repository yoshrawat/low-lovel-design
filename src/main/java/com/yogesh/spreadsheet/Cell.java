package com.yogesh.spreadsheet;

import lombok.*;

@Getter
@Setter
public class Cell<T> {
    public T value;
    public Cell prev;
    public Cell next;
    public FontType fontType;
    public boolean bold;
    public boolean italics;
}
