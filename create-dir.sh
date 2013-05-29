#/bin/bash

readonly ROOT_DIR=${ROOT_DIR:-'/tmp'}

readonly IN_DIR=${IN_DIR:-${ROOT_DIR}/incoming}
readonly OUT_DIR=${OUT_DIR:-${ROOT_DIR}/output}
readonly ERR_DIR=${ERR_DIR:-${ROOT_DIR}/error}

mkdir -p "${IN_DIR}" "${OUT_DIR}" "${ERR_DIR}"
