package com.yogesh.parkinglot.mode;

import com.yogesh.parkinglot.OutputPrinter;
import com.yogesh.parkinglot.commands.CommandExecutorFactory;
import com.yogesh.parkinglot.commands.ExitCommandExecutor;
import com.yogesh.parkinglot.model.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Mode running in which input commands are given from an interactive shell.
 */
public class InteractiveMode extends Mode {

  public InteractiveMode(
          final CommandExecutorFactory commandExecutorFactory, final OutputPrinter outputPrinter) {
    super(commandExecutorFactory, outputPrinter);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void process() throws IOException {
    outputPrinter.welcome();
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      final String input = reader.readLine();
      final Command command = new Command(input);
      processCommand(command);
      if (command.getCommandName().equals(ExitCommandExecutor.COMMAND_NAME)) {
        break;
      }
    }
  }
}
