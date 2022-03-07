#!/usr/bin/env bash

set +ex
echo Run ldapmodify for increasing sizelimit
ldapmodify -x -D "cn=directory manager" -w "$FPW" -h localhost << EOF
dn: cn=config
changetype: modify
add: nsslapd-sizelimit
nsslapd-sizelimit: 11000
EOF
LDAPMODIFY_RET=$?
set -ex
LDAP_TYPE_OR_VALUE_EXISTS=20
if [[ $LDAPMODIFY_RET -ne 0 && $LDAPMODIFY_RET -ne $LDAP_TYPE_OR_VALUE_EXISTS ]]; then
  echo ldapmodify for increasing sizelimit failed with code $LDAPMODIFY_RET
  false
fi
