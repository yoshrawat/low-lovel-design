package com.yogesh.parkinglot.model;

import com.yogesh.parkinglot.exception.*;

import java.util.*;
import java.util.stream.*;

/** Model object to represent a input command. */
public class Command {

  private static final String SPACE = " ";
  private final String commandName;
  private final List<String> params;

  public String getCommandName() {
    return commandName;
  }

  public List<String> getParams() {
    return params;
  }

  /**
   * Constructor. It takes the input line and parses the command name and param out of it. If the
   * command or its given params are not valid, then {@link InvalidCommandException} is thrown.
   *
   * @param inputLine Given input command line.
   */
  public Command(final String inputLine) {
    final List<String> tokensList =
        Arrays.stream(inputLine.trim().split(SPACE))
            .map(String::trim)
            .filter(token -> (token.length() > 0))
            .collect(Collectors.toList());

    if (tokensList.size() == 0) {
      throw new InvalidCommandException();
    }

    commandName = tokensList.get(0).toLowerCase();
    tokensList.remove(0);
    params = tokensList;
  }
}
