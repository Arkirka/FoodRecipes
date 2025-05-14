   param (
       [string]$basePath,
       [string]$className
   )

   # Определяем путь к папке command
   $commandFolder = Join-Path $basePath 'command'

   # Создаем папку command, если она не существует
   if (-not (Test-Path $commandFolder)) {
       New-Item -ItemType Directory -Path $commandFolder
   }

   # Извлекаем имя крайней папки
   $folderName = Split-Path $basePath -Leaf

   # Создаем дочернюю папку с именем в нижнем регистре
   $subfolderName = $className -replace "(?i)$folderName.*", ""
   $subfolderName = $subfolderName.Substring(0,1).ToLower() + $subfolderName.Substring(1)
   $subfolderPath = Join-Path $commandFolder $subfolderName
   New-Item -ItemType Directory -Path $subfolderPath

   # Определяем имена файлов
   $commandFileName = $className + "Command.java"
   $handlerFileName = $className + "CommandHandler.java"

   # Содержимое для Command.java
   $commandContent = @"
package ru.food.usecase.$folderName.command.$subfolderName;

import ru.food.usecase.cqrs.command.Command;
import ru.food.usecase.cqrs.command.CommandDefaultResponse;

public record ${className}Command() implements Command<CommandDefaultResponse> {}
"@

   # Содержимое для CommandHandler.java
   $handlerContent = @"
package ru.food.usecase.$folderName.command.$subfolderName;

import reactor.core.publisher.Flux;
import ru.food.usecase.cqrs.command.CommandDefaultResponse;
import ru.food.usecase.cqrs.command.CommandHandler;

public class ${className}CommandHandler implements CommandHandler<${className}Command, CommandDefaultResponse> {
    @Override
    public Flux<CommandDefaultResponse> handle(${className}Command command) {
        return Flux.just(new CommandDefaultResponse());
    }
}
"@

   # Записываем содержимое в файлы
   Set-Content (Join-Path $subfolderPath $commandFileName) $commandContent
   Set-Content (Join-Path $subfolderPath $handlerFileName) $handlerContent

