@REM
@REM  Copyright 2004 The Apache Software Foundation
@REM
@REM  Licensed under the Apache License, Version 2.0 (the "License");
@REM  you may not use this file except in compliance with the License.
@REM  You may obtain a copy of the License at
@REM
@REM      http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM  Unless required by applicable law or agreed to in writing, software
@REM  distributed under the License is distributed on an "AS IS" BASIS,
@REM  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM  See the License for the specific language governing permissions and
@REM  limitations under the License.
@REM

@rem Schema to instance tool
@rem

@echo off

setlocal
if "%XMLBEANS_LIB%" EQU "" call "%~dp0_setlib"

set cp=
set cp=%cp%;%XMLBEANS_LIB%\*

java -classpath "%cp%" org.apache.xmlbeans.impl.xsd2inst.SchemaInstanceGenerator %*

:done
