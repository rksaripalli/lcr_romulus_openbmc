inherit sbsign

SBSIGN_TARGET_BINARY = "${B}/src/boot/efi/systemd-boot${EFI_ARCH}.efi"

do_compile:append() {
    do_sbsign
}