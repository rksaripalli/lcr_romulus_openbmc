SUMMARY = "Phosphor IPMI daemon configuration"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
PR = "r1"

SRC_URI = " \
    file://cipher_list.json \
    file://dcmi_cap.json \
    file://dcmi_sensors.json \
    file://dev_id.json \
    file://power_reading.json \
    file://channel_access.json \
    file://channel_config.json \
    file://entity-map.json \
    file://cs_privilege_levels.json \
    "

S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

inherit allarch

do_fetch[noexec] = "1"
do_patch[noexec] = "1"
do_configure[noexec] = "1"
do_compile[noexec] = "1"
do_install() {
    install -d ${D}${datadir}/ipmi-providers
    install -m 0644 -D ${UNPACKDIR}/cipher_list.json \
        ${D}${datadir}/ipmi-providers/cipher_list.json
    install -m 0644 -D ${UNPACKDIR}/dcmi_cap.json \
        ${D}${datadir}/ipmi-providers/dcmi_cap.json
    install -m 0644 -D ${UNPACKDIR}/dcmi_sensors.json \
        ${D}${datadir}/ipmi-providers/dcmi_sensors.json
    install -m 0644 -D ${UNPACKDIR}/dev_id.json \
        ${D}${datadir}/ipmi-providers/dev_id.json
    install -m 0644 -D ${UNPACKDIR}/power_reading.json \
        ${D}${datadir}/ipmi-providers/power_reading.json
    install -m 0644 -D ${UNPACKDIR}/channel_access.json \
        ${D}${datadir}/ipmi-providers/channel_access.json
    install -m 0644 -D ${UNPACKDIR}/channel_config.json \
        ${D}${datadir}/ipmi-providers/channel_config.json
    install -m 0644 -D ${UNPACKDIR}/entity-map.json \
        ${D}${datadir}/ipmi-providers/entity-map.json
    install -m 0644 -D ${UNPACKDIR}/cs_privilege_levels.json \
        ${D}${datadir}/ipmi-providers/cs_privilege_levels.json
}

FILES:${PN} = " \
    ${datadir}/ipmi-providers/cipher_list.json \
    ${datadir}/ipmi-providers/dcmi_cap.json \
    ${datadir}/ipmi-providers/dcmi_sensors.json \
    ${datadir}/ipmi-providers/dev_id.json \
    ${datadir}/ipmi-providers/power_reading.json \
    ${datadir}/ipmi-providers/channel_access.json \
    ${datadir}/ipmi-providers/channel_config.json \
    ${datadir}/ipmi-providers/entity-map.json \
    ${datadir}/ipmi-providers/cs_privilege_levels.json \
    "
