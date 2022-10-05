package com.yogesh.cache.algorithms;

import lombok.*;

/**
 * Object which is inserted in the {@link DoublyLinkedList}. A single node is expected to be created
 * for each element.
 *
 * @param <E> Type of element to be inserted into the list.
 */
@Getter
public class DoublyLinkedListNode<E> {
  DoublyLinkedListNode<E> next;
  DoublyLinkedListNode<E> prev;
  E element;

  public DoublyLinkedListNode(E element) {
    this.element = element;
    this.next = null;
    this.prev = null;
  }
}
