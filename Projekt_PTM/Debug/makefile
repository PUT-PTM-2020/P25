################################################################################
# Automatically-generated file. Do not edit!
################################################################################

-include ../makefile.init

RM := rm -rf

# All of the sources participating in the build are defined here
-include sources.mk
-include Startup/subdir.mk
-include Src/subdir.mk
-include Drivers/STM32F4xx_HAL_Driver/Src/subdir.mk
-include subdir.mk
-include objects.mk

ifneq ($(MAKECMDGOALS),clean)
ifneq ($(strip $(S_DEPS)),)
-include $(S_DEPS)
endif
ifneq ($(strip $(S_UPPER_DEPS)),)
-include $(S_UPPER_DEPS)
endif
ifneq ($(strip $(C_DEPS)),)
-include $(C_DEPS)
endif
endif

-include ../makefile.defs

# Add inputs and outputs from these tool invocations to the build variables 
EXECUTABLES += \
Projekt_PTM.elf \

SIZE_OUTPUT += \
default.size.stdout \

OBJDUMP_LIST += \
Projekt_PTM.list \

OBJCOPY_BIN += \
Projekt_PTM.bin \


# All Target
all: Projekt_PTM.elf secondary-outputs

# Tool invocations
Projekt_PTM.elf: $(OBJS) $(USER_OBJS) C:\Users\mateusz.biernacki\Documents\ptm\Projekt_PTM\STM32F407VGTX_FLASH.ld
	arm-none-eabi-gcc -o "Projekt_PTM.elf" @"objects.list" $(USER_OBJS) $(LIBS) -mcpu=cortex-m4 -T"C:\Users\mateusz.biernacki\Documents\ptm\Projekt_PTM\STM32F407VGTX_FLASH.ld" --specs=nosys.specs -Wl,-Map="Projekt_PTM.map" -Wl,--gc-sections -static --specs=nano.specs -mfpu=fpv4-sp-d16 -mfloat-abi=hard -mthumb -Wl,--start-group -lc -lm -Wl,--end-group
	@echo 'Finished building target: $@'
	@echo ' '

default.size.stdout: $(EXECUTABLES)
	arm-none-eabi-size  $(EXECUTABLES)
	@echo 'Finished building: $@'
	@echo ' '

Projekt_PTM.list: $(EXECUTABLES)
	arm-none-eabi-objdump -h -S $(EXECUTABLES) > "Projekt_PTM.list"
	@echo 'Finished building: $@'
	@echo ' '

Projekt_PTM.bin: $(EXECUTABLES)
	arm-none-eabi-objcopy  -O binary $(EXECUTABLES) "Projekt_PTM.bin"
	@echo 'Finished building: $@'
	@echo ' '

# Other Targets
clean:
	-$(RM) *
	-@echo ' '

secondary-outputs: $(SIZE_OUTPUT) $(OBJDUMP_LIST) $(OBJCOPY_BIN)

.PHONY: all clean dependents
.SECONDARY:

-include ../makefile.targets
