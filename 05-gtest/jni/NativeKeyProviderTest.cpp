#include <gtest/gtest.h>

#include "NativeKeyProvider.h"

TEST(NativeKeyProviderTest, shouldProvideKey) {
	// given
	std::string expected = "deadbaca";

	// when
	std::string actual = nativekeyprovider::provide();

	// then
	ASSERT_STREQ(expected.c_str(), actual.c_str());
}
